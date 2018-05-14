import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DocsAreaComponent } from './docs-area.component';

describe('DocsAreaComponent', () => {
  let component: DocsAreaComponent;
  let fixture: ComponentFixture<DocsAreaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DocsAreaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DocsAreaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
