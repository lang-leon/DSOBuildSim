import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClassChangeWindow } from './class-change-window';

describe('ClassChangeWindow', () => {
  let component: ClassChangeWindow;
  let fixture: ComponentFixture<ClassChangeWindow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ClassChangeWindow],
    }).compileComponents();

    fixture = TestBed.createComponent(ClassChangeWindow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
